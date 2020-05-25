package com.connell.pantryproject.repository

import io.micronaut.context.annotation.Requires

@Requires(beans = DefaultMongo.class)
object MongoClientFactory {

}