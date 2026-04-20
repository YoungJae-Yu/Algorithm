class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n + 1];
        
        for (int[] booking : bookings) {
            int first = booking[0];
            int last = booking[1];
            int seats = booking[2];
            
            diff[first - 1] += seats;
            if (last < n) {
                diff[last] -= seats;
            }
        }
        
        int[] answer = new int[n];
        answer[0] = diff[0];
        
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] + diff[i];
        }
        
        return answer;
    }
}