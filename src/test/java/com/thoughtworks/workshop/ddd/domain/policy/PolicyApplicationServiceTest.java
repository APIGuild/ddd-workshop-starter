package com.thoughtworks.workshop.ddd.domain.policy;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import com.thoughtworks.workshop.ddd.domain.policy.command.BuyPolicyCommand;
import com.thoughtworks.workshop.ddd.domain.policy.model.Policy;
import com.thoughtworks.workshop.ddd.domain.policy.repository.PolicyRepository;
import com.thoughtworks.workshop.ddd.domain.policy.service.PolicyFactory;

@RunWith(MockitoJUnitRunner.class)
public class PolicyApplicationServiceTest {
    @InjectMocks
    private PolicyApplicationService policyApplicationService;

    @Mock
    private PolicyFactory policyFactory;

    @Mock
    private PolicyRepository policyRepository;

    @Test
    @Ignore // TODO(You): Workshop-2
    public void shouldBuyPolicySuccessfullyGivenBuyPolicyCommand() {
        BuyPolicyCommand command = new BuyPolicyCommand();
        Policy expectedPolicy = new Policy();
        when(policyFactory.createPolicy(command)).thenReturn(expectedPolicy);

        String policyNumber = policyApplicationService.buyPolicy(command);

        verify(policyRepository).save(expectedPolicy);
        assertThat(policyNumber, is(expectedPolicy.getPolicyNumber()));
    }
}