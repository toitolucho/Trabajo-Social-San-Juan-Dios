select *
from comidas

select * 
from menus_comidas mc
inner join menus_comidas_detalle mcd
on mc.codigo_menu_comida = mcd.codigo_menu_comida
left join comidas c
on mcd.codigo_comida = c.codigo_comida
left join categorias_comidas cc
on mcd.codigo_categoria = cc.codigo_categoria


select *
from menus_comidas_detalle mcd
left join comidas c
on mcd.codigo_comida = c.codigo_comida
left join categorias_comidas cc
on mcd.codigo_categoria = cc.codigo_categoria

select *
from ingresos

select *from egresos