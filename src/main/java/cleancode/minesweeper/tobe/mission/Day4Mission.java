//package cleancode.minesweeper.tobe.mission;
//
//public class Day4Mission {
//    public boolean validateOrder(Order order) {
//        if (order.getItems().size() == 0) {
//            log.info("주문 항목이 없습니다.");
//            return false;
//        } else {
//            if (order.getTotalPrice() > 0) {
//                if (!order.hasCustomerInfo()) {
//                    log.info("사용자 정보가 없습니다.");
//                    return false;
//                } else {
//                    return true;
//                }
//            } else if (!(order.getTotalPrice() > 0)) {
//                log.info("올바르지 않은 총 가격입니다.");
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public boolean validateOrder(Order order) {
//        if (order.getItems().size() <= 0) {
//            log.info("주문 항목이 없습니다.");
//            return false;
//        }
//        if (order.getTotalPrice() > 0) {
//            if (!order.hasCustomerInfo()) {
//                log.info("사용자 정보가 없습니다.");
//                return false;
//            }
//            return true;
//        }
//        log.info("올바르지 않은 총 가격입니다.");
//        return false;
//    }
//
//    public boolean validateOrder(Order order) {
//        if (order.hasNotItems()) {
//            log.info("주문 항목이 없습니다.");
//            return false;
//        }
//        if (order.isTotalPriceGreaterThan(0)) {
//            if (order.hasNotCustomerInfo()) {
//                log.info("사용자 정보가 없습니다.");
//                return false;
//            }
//            return true;
//        }
//        log.info("올바르지 않은 총 가격입니다.");
//        return false;
//    }
//
//    public boolean validateOrder(Order order) {
//        if (order.hasNotItems()) {
//            log.info("주문 항목이 없습니다.");
//            return false;
//        }
//        if (order.isTotalPriceLEqualOrlowerThan(0)) {
//            log.info("올바르지 않은 총 가격입니다.");
//            return false;
//        }
//        if (order.hasNotCustomerInfo()) {
//            log.info("사용자 정보가 없습니다.");
//            return false;
//        }
//        return true;
//    }
//}
//
/// **
// * 1. 오더가 유효한지 검증하자
// * 2. 검증할 오더를 넘겨 받는다
// * 3. 만약 검증할 오더에서 아이템을 뺏어와, 크기가 0 인지 확인하여, 0이라면 주문 항목이 없으므로 거짓 반환
// * 4. 그렇지 않다면, 즉 주문 항목이 있다면, 오더에서 총 가격을 뺏어와, 크기가 0보다 크다면,
// * 4-1. 오더의 사용자 정보가 있는지 없는지 체크하여, 없다면 거짓 반환. 있다면 참 반환.
// * 5. 만약 오더가 정상적인 총 가격을 가지고 있지 않다면, 로그 후 거짓 반환.
// * 6. 모든 로직에 걸리지 않았다면 참 반환.
// */
//
