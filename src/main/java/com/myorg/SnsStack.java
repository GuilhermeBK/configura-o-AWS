package com.myorg;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.events.targets.SnsTopic;
import software.amazon.awscdk.services.sns.Topic;
import software.amazon.awscdk.services.sns.subscriptions.EmailSubscription;
import software.constructs.Construct;

public class SnsStack extends Stack {
    private final SnsTopic productEventsTopics;

    public SnsStack(final Construct scope, final String id) {
        this(scope, id, null);
    }



    public SnsStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        productEventsTopics = SnsTopic.Builder.create(Topic.Builder.create(this, "ProductEventTopic")
                .topicName("product-event")
                .build())
                .build();

        productEventsTopics.getTopic().addSubscription(EmailSubscription.Builder.create("guilhermekirsch12@gmail.com")
                .json(true)
                .build());


    }

    public SnsTopic getProductEventsTopics() {
        return productEventsTopics;
    }
}
