package net.projecteuler.problem;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import net.projecteuler.problem.lib.Lib;

public class Problem66DiophantineEquation {

  public static void main(String[] args) {

    solution2_fast();

  }

  static void solution2_fast() {
    int result = 0;
    BigInteger pmax = BigInteger.ZERO;

    for(int D = 2; D <= 1000; D++){
      BigInteger limit = BigInteger.valueOf((int)Math.sqrt(D));
      BigInteger DbigInt = BigInteger.valueOf(D);
      if (limit.multiply(limit).compareTo(DbigInt) == 0) continue;

      BigInteger m = BigInteger.ZERO;
      BigInteger d = BigInteger.ONE;
      BigInteger a = limit;

      BigInteger numm1 = BigInteger.ONE;
      BigInteger num = a;

      BigInteger denm1 = BigInteger.ZERO;
      BigInteger den = BigInteger.ONE;

      while(num.multiply(num).subtract(den.multiply(den).multiply(DbigInt)).compareTo(BigInteger.ONE) != 0){
        m = d.multiply(a).subtract(m);
        d = DbigInt.subtract(m.multiply(m)).divide(d);
        a = limit.add(m).divide(d);

        BigInteger numm2 = numm1;
        numm1 = num;
        BigInteger denm2 = denm1;
        denm1 = den;

        num = a.multiply(numm1).add(numm2);
        den = a.multiply(denm1).add(denm2);
      }

      if (num.compareTo(pmax) > 0) {
        pmax = num;
        result = D;
      }
    }

    System.out.println("Result: " + result);
  }

  static void solution_bruteForce() {
    Set<BigInteger> squares = new HashSet<>();
    for (int i = 0; i < 40; i++) {
      squares.add(BigInteger.valueOf(Lib.square(i)));
    }

    // 10_000_000 checked
    squares.addAll(List.of(2, 3, 5, 6, 7, 8, 10, 11, 12, 13, 14, 15, 17, 18, 19, 20, 21,
        22, 23, 24, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46,
        47, 48, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 62, 63, 65, 66, 67, 68, 69, 70, 71, 72,
        74, 75, 76, 77, 78, 79, 80, 82, 83, 84, 85, 86, 87, 88, 90, 91, 92, 93, 95, 96, 98, 99, 101,
        102, 103, 104, 105, 107, 108, 110, 111, 112, 114, 115, 116, 117, 119, 120, 122, 123, 126, 128,
        129, 130, 131, 132, 134, 135, 136, 138, 140, 141, 142, 143, 145, 146, 147, 148, 150, 152, 153,
        154, 155, 156, 158, 159, 160, 161, 162, 164, 165, 167, 168, 170, 171, 174, 175, 176, 177, 178,
        180, 182, 183, 184, 185, 186, 187, 188, 189, 190, 192, 194, 195, 197, 198, 200, 203, 204, 205,
        206, 207, 208, 209, 210, 212, 213, 215, 216, 218, 219, 220, 221, 222, 223, 224, 226, 227, 228,
        230, 231, 232, 234, 235, 237, 238, 240, 242, 243, 245, 246, 247, 248, 252, 254, 255, 257, 258,
        260, 263, 264, 266, 267, 269, 270, 272, 273, 275, 276, 278, 279, 280, 282, 285, 287, 288, 290,
        291, 294, 296, 297, 299, 300, 303, 304, 305, 306, 308, 312, 315, 316, 318, 320, 321, 322, 323,
        325, 326, 327, 328, 330, 332, 333, 335, 336, 338, 339, 340, 342, 344, 345, 346, 348, 350, 351,
        352, 354, 357, 359, 360, 362, 363, 368, 370, 371, 372, 374, 375, 377, 378, 380, 381, 383, 384,
        385, 386, 387, 390, 392, 395, 396, 398, 399, 401, 402, 404, 405, 407, 408, 410, 411, 413, 414,
        416, 418, 420, 423, 425, 426, 427, 432, 434, 435, 437, 438, 439, 440, 442, 443, 444, 447, 448,
        450, 455, 456, 458, 462, 464, 465, 468, 469, 470, 473, 474, 475, 476, 480, 482, 483, 485, 486,
        488, 492, 494, 495, 498, 499, 503, 504, 505, 506, 507, 510, 514, 515, 516, 518, 520, 522, 525,
        527, 528, 530, 531, 536, 539, 540, 544, 545, 546, 551, 552, 555, 557, 558, 560, 563, 564, 567,
        568, 570, 572, 573, 574, 575, 577, 578, 579, 580, 582, 584, 585, 588, 590, 591, 592, 595, 600,
        602, 603, 608, 611, 612, 615, 616, 618, 620, 621, 623, 624, 626, 627, 630, 632, 635, 638, 642,
        644, 646, 648, 650, 651, 656, 658, 659, 660, 663, 665, 668, 671, 672, 674, 675, 677, 678, 680,
        684, 687, 689, 690, 693, 695, 696, 697, 702, 704, 705, 706, 707, 708, 710, 711, 712, 714, 715,
        720, 723, 725, 726, 727, 728, 730, 731, 732, 735, 736, 738, 740, 744, 747, 752, 755, 756, 759,
        760, 762, 765, 767, 768, 770, 774, 776, 777, 780, 782, 783, 785, 786, 788, 791, 792, 793, 795,
        798, 799, 800, 803, 810, 812, 813, 815, 816, 817, 818, 819, 820, 822, 824, 825, 828, 830, 836,
        837, 839, 840, 842, 843, 848, 850, 852, 855, 858, 860, 866, 867, 870, 872, 874, 875, 876, 880,
        882, 884, 885, 888, 890, 891, 892, 894, 895, 896, 897, 898, 899, 901, 902, 903, 904, 905, 906,
        908, 909, 910, 912, 915, 920, 923, 924, 927, 930, 933, 935, 936, 938, 939, 940, 942, 943, 945,
        948, 950, 952, 957, 959, 960, 962, 963, 966, 968, 975, 978, 980, 982, 983, 984, 986, 987, 990,
        992, 993, 994,118, 314, 472, 979, 985, 459, 864, 887,
        89, 201, 236, 286, 347, 356, 403, 512, 543, 561, 609, 804, 944, 73, 94, 113, 124, 125, 127,
        133, 137, 173, 179, 191, 217, 229, 239, 249, 251, 259, 274, 292, 295, 302, 310, 329, 355, 364,
        366, 369, 376, 389, 391, 422, 428, 429, 430, 452, 453, 460, 467, 471, 479, 490, 496, 497, 500,
        532, 534, 535, 542, 548, 583, 587, 594, 598, 605, 636, 640, 645, 654, 657, 670, 682, 692, 699,
        700, 703, 713, 717, 741, 743, 748, 750, 761, 775, 806, 827, 831, 832, 833, 846, 847, 851, 854,
        868, 878, 916, 918, 925, 934, 973, 995, 996, 202, 293, 311, 319, 341, 415, 513, 519, 734, 745, 779, 808, 969).stream().map(BigInteger::valueOf).collect(
        Collectors.toList()));

    Map<BigInteger, BigInteger> map = new TreeMap<>();

    int maxX = 0;
    int neededD = 0;
    BigInteger sum;

    for (BigInteger D = BigInteger.ONE; D.compareTo(BigInteger.valueOf(1000)) <= 0; D = D.add(BigInteger.ONE)) { // D

      if(squares.contains(D)) {
        continue;
      }

      System.out.println("Checking: " + D);

      boolean solutionFound = false;
      for (BigInteger x = BigInteger.valueOf(20_000_000L); x.compareTo(BigInteger.valueOf(100_000_000L)) < 0; x = x.add(BigInteger.ONE)) { // x

        if (solutionFound) {
          break;
        }

        BigInteger xSquare = x.multiply(x);

        for (BigInteger y = xSquare.subtract(BigInteger.ONE).divide(D).sqrt(); y.compareTo(x) < 0; y = y.add(BigInteger.ONE)) { // y

          sum = xSquare.subtract(y.multiply(y).multiply(D));


          if (sum.compareTo(BigInteger.ONE) < 0) {
            break;
          }

          if (sum.compareTo(BigInteger.ONE) == 0) {

            System.out.println("Solution: " + List.of(D, x, y));

            solutionFound = true;
            map.put(D, x);
            break;
          }


        }
      }
    }

    final BigInteger[] mX = {BigInteger.ZERO};
    final List<Integer> checked = new ArrayList<>();
    map.forEach((D, x) -> {
      checked.add(D.intValue());
      if (x.compareTo(mX[0]) > 0) {
        mX[0] = x;
        System.out.println("new max: " + mX[0] + " D: " + D);
      }
    });

    // 100_000 -> 339 (97970)
    // 200_000 -> 213 (194339)
    // 300_000 -> 85 (285769)
    // 400_000 -> 314 (392499)
    // 500_000 -> 459 (499850)
    // 10_000_000 -> 831 (9799705)

    System.out.println(checked);
  }
}
