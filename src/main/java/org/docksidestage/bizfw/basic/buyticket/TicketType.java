package org.docksidestage.bizfw.basic.buyticket;

public enum TicketType {
    ONE_DAY(1),
    TWO_DAY(2),
    FOUR_DAY(4);

    private final int usableDays;

    TicketType(int usableDays) {
        this.usableDays = usableDays;
    }

    public int getUsableDays() {
        return usableDays;
    }
}
