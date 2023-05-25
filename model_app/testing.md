Result of First trial Deployment:


- Version of python not suitable. [RESOLVED]

Solution: use python:3.9-slim


- The predictive operations is very memory-intensive, causing out-of memory condition and 503 Service Unavailable error. [RESOLVED]

Solution: allocate bigger memory, which at the same time warrant more cpu allocation.


- High latency, even crossing 30s threshold. [ACKNOWLEDGED]

Solution: avoid cold start by setting minimum running instance to 1, however latency still hovers around 400-500 ms. Operations on local have a latency arounf 180-280 ms. Optimization may still be possible.\


- Size of the container image is 2.7 GB. [ACKNOWLEDGED]

Solution: still trying to find what's wrong, but it may be caused by the size of the packages.
