package com.sankaran.ssm.admin.service;

import com.sankaran.ssm.admin.dtos.CodeMasterDto;

import java.util.List;

public interface CodeMasterService {

    void putCodeValue(List<CodeMasterDto> codeMasterDto);

    void putCodeValue(CodeMasterDto codeMasterDto);

    List<String> getCodeValueTypes();

    List<CodeMasterDto> getCodeMasterDetails(CodeMasterDto codeMasterDto);

    List<CodeMasterDto> filterCodeMasterDetails(String filterValue);
}
