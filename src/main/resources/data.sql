insert into product (id, json)
values
(
'1b2da7cc-b367-4196-8a78-9cfeec21f587',
'{"id":"1b2da7cc-b367-4196-8a78-9cfeec21f587","name":"Seguro de Vida","created_at":"2021-07-01T00:00:00Z","active":true,"offers":["adc56d77-348c-4bf0-908f-22d402ee715c","bdc56d77-348c-4bf0-908f-22d402ee715c","cdc56d77-348c-4bf0-908f-22d402ee715c"]}'
);

insert into offer (id, json)
values
(
'adc56d77-348c-4bf0-908f-22d402ee715c',
'{"id":"adc56d77-348c-4bf0-908f-22d402ee715c","product_id":"1b2da7cc-b367-4196-8a78-9cfeec21f587","name":"Seguro de Vida Familiar","created_at":"2021-07-01T00:00:00Z","active":true,"coverages":{"Incêndio":500000.00,"Desastres naturais":600000.00,"Responsabiliadade civil":80000.00,"Roubo":100000.00},"assistances":["Encanador","Eletricista","Chaveiro 24h","Assistência Funerária"],"monthly_premium_amount":{"max_amount":100.74,"min_amount":50.00,"suggested_amount":60.25}}'
);