package com.byes.paap;

import com.planonsoftware.platform.backend.businessrule.v3.IBusinessRule;
import com.planonsoftware.platform.backend.businessrule.v3.IBusinessRuleContext;
import com.planonsoftware.platform.backend.data.v1.IBusinessObject;

public class SetMaintenanceActivityTrade implements IBusinessRule {

    @Override
    public void execute(IBusinessObject newBO, IBusinessObject oldBO, IBusinessRuleContext context) {

        IBusinessObject service = newBO.getReferenceFieldByName("ServiceAgreementServiceRef").getValue();

        if (service != null) {
            IBusinessObject trade = service.getReferenceFieldByName("TradeRef").getValue();
            if (trade != null) {
                newBO.getReferenceFieldByName("TradeRef").setValue(trade);
            }
        }


    }
}