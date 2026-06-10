class Twitter {

    class Tweet{
        int tweetId;
        int time;
        Tweet next;

        public Tweet(int tweetId, int time){
            this.tweetId = tweetId;
            this.time = time;
            this.next = null;
        }
    }

    Map<Integer, Set<Integer>> followMap;
    Map<Integer, Tweet> tweetMap;
    int timeStamp;
    public Twitter() {
        this.followMap = new HashMap<>();
        this.tweetMap = new HashMap<>();
        this.timeStamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        timeStamp++;
        Tweet tweet = new Tweet(tweetId, timeStamp);
        tweet.next = tweetMap.get(userId);
        tweetMap.put(userId, tweet);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> newsFeed = new PriorityQueue<>((a,b) -> b.time - a.time); // max Heap
        Set<Integer> follower = followMap.getOrDefault(userId, new HashSet<>());
        if(tweetMap.containsKey(userId)){
            newsFeed.offer(tweetMap.get(userId));
        }
        for(int follow: follower){
            if(tweetMap.containsKey(follow)){
                newsFeed.offer(tweetMap.get(follow));
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!newsFeed.isEmpty() && res.size() < 10){
            Tweet tweet = newsFeed.poll();
            res.add(tweet.tweetId);
            if(tweet.next != null){
                newsFeed.offer(tweet.next);
            }
        }

        return res;

    }
    
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followMap.containsKey(followerId))
            followMap.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */