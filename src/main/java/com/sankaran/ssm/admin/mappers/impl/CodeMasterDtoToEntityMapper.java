package com.sankaran.ssm.admin.mappers.impl;

import com.sankaran.ssm.admin.dtos.CodeMasterDto;
import com.sankaran.ssm.admin.entities.CodeMaster;
import com.sankaran.ssm.admin.mappers.DtoEntityMapper;
import com.sankaran.ssm.admin.utils.SSMUtil;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CodeMasterDtoToEntityMapper implements DtoEntityMapper<CodeMasterDto, CodeMaster> {
    @Override
    public List<CodeMaster> convert(List<CodeMasterDto> sourceList) {

        return sourceList.stream().map(obj -> {
            CodeMaster codeMaster = new CodeMaster(obj.getCodeMasterId(), obj.getCodeValue(),
                    obj.getCodeDescription(), SSMUtil.convertValueToCode(obj.getCodeType()));
            codeMaster.setIsActive(obj.getIsActive());
            codeMaster.setCreatedBy(obj.getCreatedBy());
            codeMaster.setCreatedDate(obj.getCreatedDate());
            codeMaster.setModifiedBy(obj.getModifiedBy());
            codeMaster.setModifiedDate(obj.getModifiedDate());
            return codeMaster;
        }).collect(Collectors.toList());

    }

    @Override
    public CodeMaster convert(CodeMasterDto source) {
        CodeMaster codeMaster = new CodeMaster(source.getCodeMasterId(), source.getCodeValue(), source.getCodeDescription(),
                SSMUtil.convertValueToCode(source.getCodeType()));
        codeMaster.setIsActive(source.getIsActive());
        codeMaster.setCreatedBy(source.getCreatedBy());
        codeMaster.setCreatedDate(source.getCreatedDate());
        codeMaster.setModifiedBy(source.getModifiedBy());
        codeMaster.setModifiedDate(source.getModifiedDate());
        return codeMaster;
    }
}
