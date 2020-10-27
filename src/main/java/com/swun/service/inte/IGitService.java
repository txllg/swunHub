package com.swun.service.inte;

import org.springframework.stereotype.Service;

@Service
public interface IGitService {
    void checkoutBranch(String branch);
    void setupRepo();
    void pullBranchToLocal(String branch,String username);

}
