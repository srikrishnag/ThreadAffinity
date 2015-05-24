# ThreadAffinity
- Main program of this application is: MainThreadPoolTest <br />
- Used unbounded buffer solution. this may create OOM, improvement can be bounded, current went with interface def available <br />
- Used system.out.println for logging, we can use logging libraries for better control of log levels <br />
- Used non blockign method for affinity, so that there are no locks required for handling queued up tasks(non shared information for current sol) <br />
- Assumption: Number of unique jobs = Thread pool size. If we want many jobs to be mapped to smaller thread pool size we can use consistent hashing  <br />
- Naive java lib used without any external libraries
