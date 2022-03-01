/*
 * Copyright 2022 GoodData Corporation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gooddata.oauth2.server.common

import com.nimbusds.jose.jwk.JWKSet

/**
 * Stores JWKs.
 */
interface JwkCache : Cache<String, JWKSet?>

/**
 * Caffeine implementation of JWK cache.
 * @param maxSize max cache size. Default is [CaffeineCache.CACHE_MAX_SIZE].
 * @param expireAfterWriteMinutes cached values are expired after write after this value in minutes. Default is
 * [CaffeineCache.CACHE_EXPIRE_AFTER_WRITE_MINUTES].
 */
class CaffeineJwkCache(
    maxSize: Long = CACHE_MAX_SIZE,
    expireAfterWriteMinutes: Long = CACHE_EXPIRE_AFTER_WRITE_MINUTES
) : JwkCache, CaffeineCache<String, JWKSet?>(maxSize, expireAfterWriteMinutes)
