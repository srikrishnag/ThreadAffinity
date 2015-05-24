# ThreadAffinity
-Used unbounded buffer solution. this may create OOM, improvement can be bounded, current went with interace def available
-Used system.out.println for logging, we can use logging libraries for better control of log levels
-Used non blockign method for affinity, so that there are no locks required for handling queued up tasks(non shared infor for current sol)
