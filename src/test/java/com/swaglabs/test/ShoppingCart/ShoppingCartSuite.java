package com.swaglabs.test.ShoppingCart;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CartPageTest.class,
        CartPageBtnTest.class,
        CheckoutCustomerInfoTest.class
})
public class ShoppingCartSuite {
}
