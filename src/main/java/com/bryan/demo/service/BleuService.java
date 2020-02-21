package com.bryan.demo.service;

import com.bryan.demo.common.util.Result;
import com.bryan.demo.service.model.BleuResultBO;

public interface BleuService {

    // 计算bleu
    Result<BleuResultBO> calc(String source, String ref);

}
