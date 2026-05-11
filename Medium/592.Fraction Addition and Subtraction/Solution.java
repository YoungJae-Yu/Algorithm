class Solution {
    public String fractionAddition(String expression) {
        if (!expression.isEmpty() && expression.charAt(0) != '-') {
            expression = "+" + expression;
        }
        
        long numerator = 0;
        long denominator = 1;
        
        int i = 0;
        int n = expression.length();
        
        while (i < n) {
            int sign = expression.charAt(i) == '+' ? 1 : -1;
            i++;
            
            int j = i;
            while (j < n && expression.charAt(j) != '+' && expression.charAt(j) != '-') {
                j++;
            }
            
            String fraction = expression.substring(i, j);
            String[] parts = fraction.split("/");
            long num = Long.parseLong(parts[0]);
            long den = Long.parseLong(parts[1]);
            
            numerator = numerator * den + sign * num * denominator;
            denominator = denominator * den;
            
            long gcd = gcd(Math.abs(numerator), Math.abs(denominator));
            numerator /= gcd;
            denominator /= gcd;
            
            i = j;
        }
        
        return numerator + "/" + denominator;
    }
    
    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}