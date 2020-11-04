package com.swun.service;

import org.springframework.stereotype.Service;

@Service
public interface IGitService {
    void checkoutBranch(String branch,String username,String repository);
    void pullBranchToLocal(String repository, String branch, String username);
    void cloneToLocal(String username, String repository);

}
