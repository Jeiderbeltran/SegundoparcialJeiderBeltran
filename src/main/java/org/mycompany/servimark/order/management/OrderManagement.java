package org.mycompany.servimark.order.management;

import org.mycompany.servimark.order.OrderExternalAPI;
import org.mycompany.servimark.order.OrderInternalAPI;
import org.springframework.stereotype.Service;

@Service
public class OrderManagement implements OrderInternalAPI, OrderExternalAPI {
}
