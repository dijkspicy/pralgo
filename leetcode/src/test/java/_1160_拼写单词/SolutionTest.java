package _1160_拼写单词;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * auto generated
 *
 * @since 2019-08-24
 */
public class SolutionTest {
    @Test
    public void test1() {
        test(6, "atach", new String[] {
            "cat", "bt", "hat", "tree"
        });

        test(10, "welldonehoneyr", new String[] {
            "hello", "world", "leetcode"
        });
    }

    @Test
    public void test2() {
        test(0, "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp", new String[] {
            "dyiclysmffuhibgfvapygkorkqllqlvokosagyelotobicwcmebnpznjbirzrzsrtzjxhsfpiwyfhzyonmuabtlwin",
            "ndqeyhhcquplmznwslewjzuyfgklssvkqxmqjpwhrshycmvrb",
            "ulrrbpspyudncdlbkxkrqpivfftrggemkpyjl",
            "boygirdlggnh",
            "xmqohbyqwagkjzpyawsydmdaattthmuvjbzwpyopyafphx",
            "nulvimegcsiwvhwuiyednoxpugfeimnnyeoczuzxgxbqjvegcxeqnjbwnbvowastqhojepisusvsidhqmszbrnynkyop",
            "hiefuovybkpgzygprmndrkyspoiyapdwkxebgsmodhzpx",
            "juldqdzeskpffaoqcyyxiqqowsalqumddcufhouhrskozhlmobiwzxnhdkidr",
            "lnnvsdcrvzfmrvurucrzlfyigcycffpiuoo",
            "oxgaskztzroxuntiwlfyufddl",
            "tfspedteabxatkaypitjfkhkkigdwdkctqbczcugripkgcyfezpuklfqfcsccboarbfbjfrkxp",
            "qnagrpfzlyrouolqquytwnwnsqnmuzphne",
            "eeilfdaookieawrrbvtnqfzcricvhpiv", "sisvsjzyrbdsjcwwygdnxcjhzhsxhpceqz",
            "yhouqhjevqxtecomahbwoptzlkyvjexhzcbccusbjjdgcfzlkoqwiwue", "hwxxighzvceaplsycajkhynkhzkwkouszwaiuzqcleyflqrxgjsvlegvupzqijbornbfwpefhxekgpuvgiyeudhncv",
            "cpwcjwgbcquirnsazumgjjcltitmeyfaudbnbqhflvecjsupjmgwfbjo", "teyygdmmyadppuopvqdodaczob", "qaeowuwqsqffvibrtxnjnzvzuuonrkwpysyxvkijemmpdmtnqxwekbpfzs",
            "qqxpxpmemkldghbmbyxpkwgkaykaerhmwwjonrhcsubchs"
        });
    }

    private void test(int size, String chars, String[] words) {
        assertEquals(size, new Solution().countCharacters(words, chars));
    }
}