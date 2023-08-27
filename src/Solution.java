import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.*;

class Pair<L, R> {
    L left;
    R right;

    private Pair() {

    }

    private Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public static Pair of(Object left, Object right) {
        return new Pair<>(left, right);
    }

    public L getLeft() {
        return this.left;
    }

    public R getRight() {
        return this.right;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
public class Solution {
    public static void main(String[] args) throws ParseException {
        String startDateStr = "2017-05-19 07:15:00";
        String endDateStr = "2099-12-12 11:30:59";
        String startBoundaryStr = "2022-12-06 16:50:28";
        String endBoundaryStr = "2092-12-06 16:50:28";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date enStartDate = simpleDateFormat.parse(startDateStr);
        Date enEndDate = simpleDateFormat.parse(endDateStr);
        Date avStartDate = simpleDateFormat.parse(startBoundaryStr);
        Date avEndDate = simpleDateFormat.parse(endBoundaryStr);

        System.out.println(calculateDate(avStartDate, avEndDate, enStartDate, enEndDate));
        System.out.println(computeLaerDates(avStartDate, avEndDate, enStartDate, enEndDate));
    }

    protected static Pair<Date, Date> calculateDate(Date avStart, Date avEnd, Date enStart, Date enEnd) {
        // Check if the availability window is not overlapping
        if (Objects.nonNull(avEnd) && Objects.nonNull(enEnd) && (avEnd.before(enStart) || enEnd.before(avStart))) {
            return null;
        }

        // Defaulting avStart and avEnd to enStart and enEnd in case either not set
        avStart = Objects.isNull(avStart) ? enStart : avStart;
        avEnd = Objects.isNull(avEnd) ? enEnd : avEnd;

        // The calculated date output defaulted to entitlement start and end dates
        Date startDate = enStart;
        Date endDate = enEnd;

        /*
            In case the availability starts after entitlement start.
            Then calculated start date is equal to availability start date
         */
        if (avStart.after(enStart)) {
            startDate = avStart;
        }

        /*
             In case the availability end date is before the entitlement end
             then the calculated end date is equal to availability end date
         */
        if (avEnd.before(enEnd)) {
            endDate = avEnd;
        }

        return Pair.of(startDate, endDate);
    }

    private static Pair<Date, Date> computeLaerDates(Date avStart, Date avEnd, Date enStart, Date enEnd) {
        Date startDate = enStart;
        Date endDate = enEnd;
        
        if (avStart != null && enEnd != null && enEnd.before(avStart) || (avEnd != null && enStart != null && avEnd.before(enStart))) {
            return null;
        } else {
            if (enStart != null && (avStart == null || (avStart != null && avStart.before(enStart)))) {
                startDate = enStart;
            } else {
                startDate = avStart;
            }
            if (enEnd != null && avEnd == null) {
                endDate = enEnd;
            } else if (enEnd != null && (avEnd == null || (avEnd != null && avEnd.after(enEnd)))) {
                endDate = enEnd;
            } else {
                endDate = avEnd;
            }
        }
        return Pair.of(startDate, endDate);
    }
}
