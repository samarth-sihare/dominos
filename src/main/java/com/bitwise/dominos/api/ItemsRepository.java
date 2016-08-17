package com.bitwise.dominos.api;

import java.util.List;

/**
 * Created by kirankumarbs on 8/17/2016.
 */
public interface ItemsRepository {

    <T> List<T> getItems();
}
