// SPDX-License-Identifier: Apache-2.0
package org.hiero.sdk;

import io.github.jsonSnapshot.SnapshotMatcher;
import org.hiero.sdk.proto.QueryHeader;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AccountBalanceQueryTest {
    @BeforeAll
    public static void beforeAll() {
        SnapshotMatcher.start(Snapshot::asJsonString);
    }

    @AfterAll
    public static void afterAll() {
        SnapshotMatcher.validateSnapshots();
    }

    @Test
    void shouldSerializeWithAccountId() {
        var builder = org.hiero.sdk.proto.Query.newBuilder();
        new AccountBalanceQuery()
                .setAccountId(AccountId.fromString("0.0.5005"))
                .onMakeRequest(builder, QueryHeader.newBuilder().build());
        SnapshotMatcher.expect(builder.build().toString().replaceAll("@[A-Za-z0-9]+", ""))
                .toMatchSnapshot();
    }

    @Test
    void shouldSerializeWithContractId() {
        var builder = org.hiero.sdk.proto.Query.newBuilder();
        new AccountBalanceQuery()
                .setContractId(ContractId.fromString("0.0.5005"))
                .onMakeRequest(builder, QueryHeader.newBuilder().build());
        SnapshotMatcher.expect(builder.build().toString().replaceAll("@[A-Za-z0-9]+", ""))
                .toMatchSnapshot();
    }
}
