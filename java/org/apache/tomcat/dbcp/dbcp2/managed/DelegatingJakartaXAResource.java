/**
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.tomcat.dbcp.dbcp2.managed;


import javax.transaction.xa.XAException;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;

/**
 * Delegates from a javax XAResource to a jakarta XAResource.
 */
public class DelegatingJakartaXAResource implements jakarta.transaction.xa.XAResource {
    private javax.transaction.xa.XAResource delegate;

    public DelegatingJakartaXAResource(javax.transaction.xa.XAResource delegate) {
        this.delegate = delegate;
    }

    @Override
    public void commit(Xid xid, boolean b) throws XAException {
        delegate.commit(xid, b);
    }

    @Override
    public void end(Xid xid, int i) throws XAException {
        delegate.end(xid, i);
    }

    @Override
    public void forget(Xid xid) throws XAException {
        delegate.forget(xid);
    }

    @Override
    public int getTransactionTimeout() throws XAException {
        return delegate.getTransactionTimeout();
    }

    @Override
    public boolean isSameRM(XAResource xaResource) throws XAException {
        return delegate.isSameRM(xaResource);
    }

    @Override
    public int prepare(Xid xid) throws XAException {
        return delegate.prepare(xid);
    }

    @Override
    public Xid[] recover(int i) throws XAException {
        return delegate.recover(i);
    }

    @Override
    public void rollback(Xid xid) throws XAException {
        delegate.rollback(xid);
    }

    @Override
    public boolean setTransactionTimeout(int i) throws XAException {
        return delegate.setTransactionTimeout(i);
    }

    @Override
    public void start(Xid xid, int i) throws XAException {

    }
}
