package org.docksidestage.bizfw.basic.buyticket;

public enum TicketType {
    ONE_DAY(1),
    TWO_DAY(2);

    private final int usableDays;

    private TicketType(int usableDays) {
        this.usableDays = usableDays;
    }

    public int getUsableDays() {
        return usableDays;
    }
}
