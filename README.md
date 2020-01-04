# Leitstand Jobs

The Leitstand Jobs module provides a generic model to orchestrate and run arbitrary management jobs.
A _job_ is a set of tasks that have to be executed in a specified order.
Each task represents a single REST API invocation.

The [leitstand-job-model](./leitstand-jobs-model/README.md) project contains the _Leitstand Job Scheduler_ and the _Leitstand Job Management_ implementation.

The [leitstand-job-api](./leitstand-jobs-api/README.md) project contains the transactional _Leitstand Job API._

The [leitstand-job-ui](./leitstand-jobs-ui/README.md) project contains the _Leitstand Job UI module_ to inspect and manage Leitstand jobs.