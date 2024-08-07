class MyQueue 
{
    Stack<Integer> st;
    Stack<Integer> st1;
    public MyQueue() 
    {
        st = new Stack<>();
        st1 = new Stack<>();
    }
    
    public void push(int x) 
    {
        st.push(x);
    }
    
    public int pop() 
    {
        while(!st.isEmpty())
        {
            st1.push(st.pop());
        }
        int x =st1.pop();
        while(!st1.isEmpty())
        {
            st.push(st1.pop());
        }
        return x;
    }
    
    public int peek() 
    {
        while(!st.isEmpty())
        {
            st1.push(st.pop());
        }
        int x =st1.peek();
        while(!st1.isEmpty())
        {
            st.push(st1.pop());
        }
        return x;
    }
    
    public boolean empty() 
    {
        if(st.isEmpty())
            return st1.isEmpty();
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */