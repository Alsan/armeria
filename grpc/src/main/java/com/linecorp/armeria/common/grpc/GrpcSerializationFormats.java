/*
 *  Copyright 2017 LINE Corporation
 *
 *  LINE Corporation licenses this file to you under the Apache License,
 *  version 2.0 (the "License"); you may not use this file except in compliance
 *  with the License. You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations
 *  under the License.
 */

package com.linecorp.armeria.common.grpc;

import static java.util.Objects.requireNonNull;

import java.util.Set;

import com.google.common.collect.ImmutableSet;

import com.linecorp.armeria.common.SerializationFormat;

/**
 * GRPC-related {@link SerializationFormat} instances.
 */
public final class GrpcSerializationFormats {

    /**
     * GRPC protobuf serialization format.
     */
    public static final SerializationFormat PROTO = SerializationFormat.of("gproto");

    /**
     * GRPC JSON serialization format.
     */
    public static final SerializationFormat JSON = SerializationFormat.of("gjson");

    /**
     * GRPC-web protobuf serialization format.
     */
    public static final SerializationFormat PROTO_WEB = SerializationFormat.of("gproto-web");

    /**
     * GRPC-web JSON serialization format.
     */
    public static final SerializationFormat JSON_WEB = SerializationFormat.of("gjson-web");

    private static final Set<SerializationFormat> GRPC_FORMATS = ImmutableSet.of(
            PROTO, JSON, PROTO_WEB, JSON_WEB);

    /**
     * Returns the set of all known GRPC serialization formats.
     */
    public static Set<SerializationFormat> values() {
        return GRPC_FORMATS;
    }

    /**
     * Returns whether the specified {@link SerializationFormat} is GRPC.
     */
    public static boolean isGrpc(SerializationFormat format) {
        return values().contains(requireNonNull(format, "format"));
    }

    /**
     * Is a proto-based GRPC serialization format.
     */
    public static boolean isProto(SerializationFormat format) {
        requireNonNull(format, "format");
        return format == PROTO || format == PROTO_WEB;
    }

    /**
     * Is a json-based GRPC serialization format.
     */
    public static boolean isJson(SerializationFormat format) {
        requireNonNull(format, "format");
        return format == JSON || format == JSON_WEB;
    }

    /**
     * Returns whether the specified {@link SerializationFormat} is GRPC-web, the subset of GRPC that supports
     * browsers.
     */
    public static boolean isGrpcWeb(SerializationFormat format) {
        requireNonNull(format, "format");
        return format == PROTO_WEB || format == JSON_WEB;
    }

    private GrpcSerializationFormats() {}
}
