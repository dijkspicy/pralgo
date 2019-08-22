/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2020. All rights reserved.
 */

package ProfessionalJava;

import java.util.Scanner;

/**
 * auto generated
 *
 * @since 2019/8/20
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String out = main0(line);
            if (out != null) {
                System.out.println(out);
            }
        }
    }

    private static String main0(String line) {

        return null;
    }

    private interface Expression {
        double interpret(String context);
    }

    private static class NumberExpression implements Expression {
        @Override
        public double interpret(String context) {
            return Double.parseDouble(context);
        }
    }

    private static class AddExpression implements Expression {
        private final Expression left;
        private final Expression right;

        AddExpression(Expression left, Expression right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public double interpret(String context) {
            return this.left.interpret(context);
        }
    }
}
