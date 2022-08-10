class numCheck
{
    public boolean check(String s)
    {
        for (int i=0;i<s.length();i++)
        {
            if (!(Character.isDigit(s.charAt(i))))
            { 
                //new erron();
                return false;

            }
        }
        int c=0;
        if(s.charAt(0)=='0' || s.length()<10||s.length()>10)
        {//new erron();
            return false;
        }
        return true;
    }
}