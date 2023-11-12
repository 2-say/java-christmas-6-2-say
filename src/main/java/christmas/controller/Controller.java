package christmas.controller;

import christmas.domain.Badge;
import christmas.domain.Bilge;
import christmas.domain.Menu;
import christmas.service.DiscountService;
import christmas.utils.Utils;
import christmas.validation.Validation;
import christmas.view.InputView;
import christmas.view.OutputView;

import java.time.LocalDate;
import java.util.Map;

public class Controller {

    private Bilge bilge;
    private DiscountService discountService;

    public void run() {
        OutputView.infoMessage();
        initialize();
        result();
    }

    private void initialize() {
        int day = getDayFromUserInput();
        LocalDate date = LocalDate.of(LocalDate.now().getYear(), 12, day);
        Map<Menu, Integer> menuIntegerMap = getMenuFromUserInput();
        bilge = new Bilge(date, menuIntegerMap);
        discountService = new DiscountService(bilge);
    }

    private int getDayFromUserInput() {
        while (true) {
            String inputDay = InputView.inputDayMessage();
            try {
                Validation.validateStringToInteger(inputDay);
                return Utils.stringToInteger(inputDay);
            } catch (IllegalArgumentException e){}
        }
    }

    private Map<Menu, Integer> getMenuFromUserInput() {
        while (true) {
            try {
                String inputMenu = InputView.inputMenuMessage();
                return Utils.processEntry(inputMenu);
            } catch (IllegalArgumentException e){}
        }
    }

    private void result() {
        OutputView.infoEventMessage();
        printMenuDetails();
        int applyDiscount = discountService.applyDiscount();
        printFreebie();
        printBenefitDetails();
        printTotalBenefit(applyDiscount);
        printAfterDiscount();
        printBadge(applyDiscount);
    }

    private void printMenuDetails() {
        OutputView.printMenuQuantities(bilge);
        OutputView.printBeforeDiscount(bilge);
    }

    private void printFreebie() {
        boolean freebie = discountService.hasChampagneDiscount();
        OutputView.printFreebie(freebie);
    }

    private void printBenefitDetails() {
        Map<String, Integer> discountDetails = discountService.getDiscountDetails();
        OutputView.printBenefitDetails(discountDetails);
    }

    private void printTotalBenefit(int applyDiscount) {
        OutputView.printTotalBenefit(applyDiscount);
    }

    private void printAfterDiscount() {
        int totalDiscount = discountService.calculateNoneChampagneDiscount();
        OutputView.printAfterDiscount(bilge.getTotalPrice() - totalDiscount);
    }

    private void printBadge(int applyDiscount) {
        Badge userBadge = Badge.getBadgeByBenefit(applyDiscount);
        OutputView.pringBadge(userBadge);
    }
}
