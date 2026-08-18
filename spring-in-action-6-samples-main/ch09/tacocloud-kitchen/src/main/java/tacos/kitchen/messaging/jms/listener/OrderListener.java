package tacos.kitchen.messaging.jms.listener;

import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import tacos.TacoOrder;
import tacos.kitchen.KitchenUI;

@Profile("jms-listener")                          // only active with this profile
@Component
public class OrderListener {

  private KitchenUI ui;

  public OrderListener(KitchenUI ui) {
    this.ui = ui;
  }

  @JmsListener(destination = "tacocloud.order.queue")  // invoked automatically per message
  public void receiveOrder(TacoOrder order) {
    ui.displayOrder(order);
  }
}