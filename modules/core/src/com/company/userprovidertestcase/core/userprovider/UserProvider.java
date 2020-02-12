package com.company.userprovidertestcase.core.userprovider;


import com.haulmont.addon.bproc.entity.ExecutionData;
import com.haulmont.addon.bproc.provider.UserListProvider;
import com.haulmont.addon.bproc.service.BprocRuntimeService;
import com.haulmont.cuba.security.entity.User;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Component("user_provider")
public class UserProvider implements UserListProvider {

    @Inject
    private BprocRuntimeService bprocRuntimeService;

    @Inject
    private Logger log;

    @Override
    public List<User> get(String executionId) {
        List<ExecutionData> list = bprocRuntimeService.createExecutionDataQuery().executionId(executionId).list();
        if (list.size() == 0) {
            System.out.printf("ERROR: Execution with id %s is missing in BprocRuntimeService\n", executionId);
        }
        return new ArrayList<>();
    }
}






