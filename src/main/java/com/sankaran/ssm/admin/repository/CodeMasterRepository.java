package com.sankaran.ssm.admin.repository;

import com.sankaran.ssm.admin.entities.CodeMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CodeMasterRepository extends JpaRepository<CodeMaster, Long> {

    @Query(value = "select distinct codeType from CodeMaster")
    List<String> getCodeValueTypes();

    @Query(nativeQuery = true,name = "codeMasterDetails")
    List<CodeMaster> getCodeMaster(@Param(value = "codeValue") String codeValue,
                                   @Param(value = "codeDescription") String codeDescription,
                                   @Param(value = "codeType") String codeType);

    @Query(value = "select cm from CodeMaster cm where upper(cast(cm.codeMasterId as string )) like %:value% or " +
            "upper(cm.codeValue) like %:value% or upper(cm.codeDescription) like %:value% or " +
            "upper(cm.codeType) like %:value% ")
    List<CodeMaster> filterCodeMasterDetails(@Param(value = "value") String value);
}
