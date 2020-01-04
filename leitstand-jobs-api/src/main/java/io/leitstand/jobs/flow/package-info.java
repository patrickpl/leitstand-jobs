/*
 * (c) RtBrick, Inc - All rights reserved, 2015 - 2019
 */
/**
 * Contains all flows that orchestrates transactional operations to a single flow.
 * <p>
 * All scheduler services are idempotent.
 * A retry is supported without restrictions whenever a flow execution fails.
 * All flows are annotated with the {@link ControlFlow} stereotype.
 * </p>
 */
package io.leitstand.jobs.flow;
