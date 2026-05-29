package io.brau.aws_project02.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import io.brau.aws_project02.model.ProductEventLog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductEventLogRepository {

    private final DynamoDBMapper dynamoDBMapper;

    public ProductEventLogRepository(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public ProductEventLog save(ProductEventLog productEventLog) {
        dynamoDBMapper.save(productEventLog);
        return productEventLog;
    }

    public Iterable<ProductEventLog> findAll() {
        return dynamoDBMapper.scan(ProductEventLog.class, new DynamoDBScanExpression());
    }

    public List<ProductEventLog> findAllByPk(String code) {
        ProductEventLog hashKey = new ProductEventLog();
        hashKey.setPk(code);

        DynamoDBQueryExpression<ProductEventLog> query = new DynamoDBQueryExpression<ProductEventLog>()
                .withHashKeyValues(hashKey);

        return dynamoDBMapper.query(ProductEventLog.class, query);
    }

    public List<ProductEventLog> findAllByPkAndSkStartsWith(String code, String eventType) {
        ProductEventLog hashKey = new ProductEventLog();
        hashKey.setPk(code);

        Condition rangeKeyCondition = new Condition()
                .withComparisonOperator(ComparisonOperator.BEGINS_WITH)
                .withAttributeValueList(new AttributeValue().withS(eventType));

        DynamoDBQueryExpression<ProductEventLog> query = new DynamoDBQueryExpression<ProductEventLog>()
                .withHashKeyValues(hashKey)
                .withRangeKeyCondition("sk", rangeKeyCondition);

        return dynamoDBMapper.query(ProductEventLog.class, query);
    }
}
