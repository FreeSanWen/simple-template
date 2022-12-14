package cn.penguin.workflow.common;

import org.activiti.api.runtime.shared.identity.UserGroupManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class WorkflowConfig {


    /**
     * 排除 activiti 和 security 的默认要求实现 userDetailService
     *
     * @return
     */
    @Bean
    public UserGroupManager userGroupManager() {
        return new UserGroupManager() {
            @Override
            public List<String> getUserGroups(String s) {
                return null;
            }

            @Override
            public List<String> getUserRoles(String s) {
                return null;
            }

            @Override
            public List<String> getGroups() {
                return null;
            }

            @Override
            public List<String> getUsers() {
                return null;
            }
        };
    }
}
