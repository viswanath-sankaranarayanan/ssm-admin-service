package com.sankaran.ssm.admin.service.impl;

import com.sankaran.ssm.admin.dtos.CodeMasterDto;
import com.sankaran.ssm.admin.entities.CodeMaster;
import com.sankaran.ssm.admin.mappers.impl.CodeMasterDtoToEntityMapper;
import com.sankaran.ssm.admin.mappers.impl.CodeMasterEntityToDtoMapper;
import com.sankaran.ssm.admin.repository.CodeMasterRepository;
import com.sankaran.ssm.admin.service.CodeMasterService;
import com.sankaran.ssm.admin.utils.SSMUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CodeMasterServiceImpl implements CodeMasterService {

    @Autowired
    CodeMasterRepository codeMasterRepository;

    @Autowired
    CodeMasterDtoToEntityMapper codeMasterDtoToEntityMapper;

    @Autowired
    CodeMasterEntityToDtoMapper codeMasterEntityToDtoMapper;

    @Override
    public void putCodeValue(List<CodeMasterDto> codeMasterDto) {
        codeMasterDto = codeMasterDto.stream().map(obj -> {
            obj.setIsActive(true);
            obj.setCreatedBy("SYSTEM");
            obj.setCreatedDate(LocalDateTime.now());
            obj.setModifiedBy("SYSTEM");
            obj.setModifiedDate(LocalDateTime.now());
            return obj;
        }).collect(Collectors.toList());
        List<CodeMaster> codeMaster = codeMasterDtoToEntityMapper.convert(codeMasterDto);
        codeMasterRepository.saveAll(codeMaster);
    }

    /**
     * @param codeMasterDto
     */
    @Override
    public void putCodeValue(CodeMasterDto codeMasterDto) {
        if (Objects.isNull(codeMasterDto.getCodeMasterId())){
            codeMasterDto.setCreatedDate(LocalDateTime.now());
        }else {
            updateExistingCodeMasterDetail(codeMasterDto);
        }
        codeMasterDto.setModifiedDate(LocalDateTime.now());
        codeMasterDto.setIsActive(true);
        CodeMaster codeMaster = codeMasterDtoToEntityMapper.convert(codeMasterDto);
        codeMasterRepository.saveAndFlush(codeMaster);
    }

    @Override
    public List<String> getCodeValueTypes() {
        List<String> codeValueTypes = codeMasterRepository.getCodeValueTypes();
        return codeValueTypes.stream().map(type -> {
            return SSMUtil.convertCodeToValue(type);
        }).collect(Collectors.toList());
    }

    @Override
    public List<CodeMasterDto> getCodeMasterDetails(CodeMasterDto codeMasterDto) {
        List<CodeMaster> codeMasterList = codeMasterRepository.getCodeMaster(codeMasterDto.getCodeValue(),
                codeMasterDto.getCodeDescription(), SSMUtil.convertValueToCode(codeMasterDto.getCodeType()));
        return codeMasterEntityToDtoMapper.convert(codeMasterList);
    }

    /**
     * @param filterValue
     * @return
     */
    @Override
    public List<CodeMasterDto> filterCodeMasterDetails(String filterValue) {
        List<CodeMaster> codeMasterList = codeMasterRepository.filterCodeMasterDetails(filterValue.toUpperCase());
        return codeMasterEntityToDtoMapper.convert(codeMasterList);
    }


    private void updateExistingCodeMasterDetail(CodeMasterDto codeMasterDto){
        Optional<CodeMaster> existingCodeMasterDetail = codeMasterRepository.findById(codeMasterDto.getCodeMasterId());
        if (existingCodeMasterDetail.isPresent()){
            codeMasterDto.setCreatedDate(existingCodeMasterDetail.get().getCreatedDate());
            codeMasterDto.setCreatedBy(existingCodeMasterDetail.get().getCreatedBy());
        }
    }
}
