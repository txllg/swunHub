package com.swun.service;

import com.swun.domain.RepoFile;

import java.util.List;

public interface IRepoService {
    List<RepoFile> getFile(String path);
}
