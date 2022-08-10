class SmsCheck
{
    void work() throws Exception
    {
        if (new DeviceChecker().work())

            new sms_gui().main();
    }
}