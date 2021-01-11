/*
 * JBoss, Home of Professional Open Source.
 *
 * Copyright 2016 Red Hat, Inc., and individual contributors
 * as indicated by the @author tags.
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

package org.wildfly.openssl;

import static org.wildfly.openssl.OpenSSLEngine.isTLS13Supported;

import org.junit.Assume;
import org.junit.Test;

/**
 * @author <a href="mailto:jperkins@redhat.com">James R. Perkins</a>
 */
public class ClientSessionTest extends ClientSessionTestBase {


    @Test(timeout=90000)
    public void testOpenSsl() throws Exception {
        testSessionId(SSLTestUtils.createSSLContext("openssl.TLSv1.2"), "openssl.TLSv1.2");
    }


    @Test(timeout=90000)
    public void testSessionTimeoutOpenSsl() throws Exception {
        testSessionTimeout("openssl.TLSv1.2", "openssl.TLSv1.2");
    }


    @Test(timeout=90000)
    public void testSessionTimeoutOpenSslTLS13() throws Exception {
        Assume.assumeTrue(isTLS13Supported());
        testSessionTimeoutTLS13("openssl.TLSv1.3", "openssl.TLSv1.3");
    }

}
