/*
 * Copyright Ningbo Qishan Technology Co., Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mds.group.purchase.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;

import java.io.File;

/**
 * The type File upload util.
 *
 * @author pavawi
 */
public class FileUploadUtil {


    private static final String UPLOAD_DIR = "/mydata/file_store/";

    private static final String BASE_URL = "https://demo.bgniao.cn";

    public static String uploadImage(File file, String appmodelId) {
        String suffix = FileUtil.extName(file);
        String filename = appmodelId + File.separator + IdUtil.fastSimpleUUID() + StrUtil.DOT + suffix;
        File serverFile = new File(UPLOAD_DIR + filename);
        FileUtil.copy(file, serverFile, true);
        return BASE_URL + serverFile.getAbsolutePath();
    }

}
