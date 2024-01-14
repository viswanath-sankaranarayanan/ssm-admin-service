package com.sankaran.ssm.admin.mappers.impl;

import com.sankaran.ssm.admin.dtos.CodeMasterDto;
import com.sankaran.ssm.admin.entities.CodeMaster;
import com.sankaran.ssm.admin.mappers.DtoEntityMapper;
import com.sankaran.ssm.admin.utils.SSMUtil;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CodeMasterEntityToDtoMapper implements DtoEntityMapper<CodeMaster, CodeMasterDto> {
    @Override
    public CodeMasterDto convert(CodeMaster source) {
        return new CodeMasterDto(source.getCodeMasterId(), source.getCodeValue(), source.getCodeDescription(),
                SSMUtil.convertCodeToValue(source.getCodeType()));
    }

    @Override
    public List<CodeMasterDto> convert(List<CodeMaster> sourceList) {
        return sourceList.stream().map(source -> {
            return new CodeMasterDto(source.getCodeMasterId(), source.getCodeValue(), source.getCodeDescription(),
                    SSMUtil.convertCodeToValue(source.getCodeType()));
        }).collect(Collectors.toList());
    }
}
