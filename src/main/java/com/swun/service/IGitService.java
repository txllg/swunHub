package com.swun.service;

import com.swun.domain.RepoFile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IGitService {
    List<RepoFile> checkoutBranch(String branch, String username, String repository);
    void pullBranchToLocal(String repository, String branch, String username);
    void cloneToLocal(String username, String repository);

}
