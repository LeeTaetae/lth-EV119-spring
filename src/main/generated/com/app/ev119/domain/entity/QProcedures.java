package com.app.ev119.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProcedures is a Querydsl query type for Procedures
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProcedures extends EntityPathBase<Procedures> {

    private static final long serialVersionUID = -1208403775L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProcedures procedures = new QProcedures("procedures");

    public final StringPath diseaseName = createString("diseaseName");

    public final QFirstAid firstAid;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QProcedures(String variable) {
        this(Procedures.class, forVariable(variable), INITS);
    }

    public QProcedures(Path<? extends Procedures> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProcedures(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProcedures(PathMetadata metadata, PathInits inits) {
        this(Procedures.class, metadata, inits);
    }

    public QProcedures(Class<? extends Procedures> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.firstAid = inits.isInitialized("firstAid") ? new QFirstAid(forProperty("firstAid")) : null;
    }

}

