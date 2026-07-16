import React from "react";
import styles from "./CohortDetails.module.css";

function CohortDetails(props) {

    const cohort = props.cohort;

    return (
        <div className={styles.box}>

            <h3
                style={{
                    color:
                        cohort.currentStatus === "Ongoing"
                            ? "green"
                            : "blue"
                }}
            >
                {cohort.cohortName}
            </h3>

            <dl>
                <dt>Current Status</dt>
                <dd>{cohort.currentStatus}</dd>

                <dt>Coach</dt>
                <dd>{cohort.coach}</dd>

                <dt>Trainer</dt>
                <dd>{cohort.trainer}</dd>

                <dt>Start Date</dt>
                <dd>{cohort.startDate}</dd>

                <dt>Completed On</dt>
                <dd>{cohort.completedOn}</dd>
            </dl>

        </div>
    );
}

export default CohortDetails;