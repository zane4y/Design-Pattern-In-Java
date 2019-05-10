package algorithm;

/**
 * @author luzy
 * viva la vida
 **/
public class BM {

    public static void main(String[] args) {
        String input = "ABCDABCDAFABCD";
        String search = "CDAF";

        int start = 0;
        int searchLength = search.length();
        // 比较用的两个窗口
        char[] searchBox = search.toCharArray();
        char[] toSearch = new char[search.length()];
        do {
            input.getChars(start, start + searchLength, toSearch, 0);
            int res = compare(toSearch, searchBox);
            if (res == 0) {
                System.out.println("查找成功，从位置" + start + "开始匹配成功");
                break;
            } else {
                start = start + res;
            }
        } while (start + searchLength <= input.length());
        System.out.println("完成任务");
    }

    /**
     * 滑动窗口的比较函数，不考虑好后缀的优化
     */
    private static int compare(char[] input, char[] searchBox) {
        int i = searchBox.length - 1;
        // 如果匹配成功，左滑比较，比较不成功，退出循环
        do {
            if (input[i] == searchBox[i]) {
                i--;
            } else {
                break;
            }
        } while (i >= 0);

        if (i < 0) {
            return 0;
        } else {
            char brokenChar = input[i];
            int lastMatch = -1;
            for (int j = 0; j < input.length; j++) {
                if (searchBox[j] == brokenChar) {
                    lastMatch = j;
                    break;
                }
            }

            return i - lastMatch;
        }
    }

}
