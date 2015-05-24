# ThreadAffinity
- Main program of this application is: MainThreadPoolTest <br />
- Used unbounded buffer solution, this may create OOM, improvement is to use bounded queueing, current approach is developed on top of interface definition available that has only poolsize as a state variable <br />
- Used system.out.println for logging, we can use logging libraries for better control of log levels(Naive java lib used without any external libraries) <br />
- Used non blocking method for thread affinity, so that there are no locks required for handling queued up tasks(non shared information for current sol) <br />
- Assumption: Number of unique jobs = Thread pool size. If we want many jobs to be mapped to smaller thread pool size we can use consistent hashing  <br />

