class Twitter {
    private Map<Integer, User> users;
    private int timestamp;

    public Twitter() {
        users = new HashMap<>();
        timestamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!users.containsKey(userId)) users.put(userId, new User(userId));

        User user = users.get(userId);
        Tweet newTweet = new Tweet(tweetId, timestamp++);

        newTweet.next = user.head;
        user.head = newTweet;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();

        if (!users.containsKey(userId)) return feed;
        
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);
        User user = users.get(userId);

        for (int followeeId : user.following) {
            User followee = users.get(followeeId);
            if (followee != null && followee.head != null) pq.offer(followee.head);
        }

        while (!pq.isEmpty() && feed.size() < 10) {
            Tweet current = pq.poll();
            feed.add(current.tweetId);
            if (current.next != null) pq.offer(current.next);
        }

        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)) users.put(followerId, new User(followerId));
        if(!users.containsKey(followeeId)) users.put(followeeId, new User(followeeId));
        users.get(followerId).following.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)) return;
        if(followerId == followeeId) return;
        users.get(followerId).following.remove(followeeId);
    }

    class Tweet {
        int tweetId;
        int timestamp;
        Tweet next;

        Tweet(int tweetId, int timestamp) {
            this.tweetId = tweetId;
            this.timestamp = timestamp;
            this.next = null;
        }
    }

    class User {
        int userId;
        Set<Integer> following;
        Tweet head;

        User(int userId) {
            this.userId = userId;
            following = new HashSet<>();
            following.add(userId); // User follows themselves
            head = null;
        }
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