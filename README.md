# Spring Chaos

Currently a proof of concept.

### Goals

- ultra simple to add to a spring boot application
- configuration to be simple, via environment variable
- able to introduce 503 (Service Unavailable) responses
- able to introduce configurable latency

### Implementation notes:

- Registers with the spring boot auto-configuration
- Registers interceptors with the web MVC configuration
- Reads configuration from environment variables
  - `CHAOS_LATENCY_MILLISECONDS` (default: 0)
  - `CHAOS_MAKE_UNAVAILABLE` (default: false)
- Interceptors are registered at startup (application context)







