import request from '@/utils/request'

export function fetchList(query) {
  return request({
    url: '/howe/article/list',
    method: 'get',
    params: query
  })
}

export function fetchArticle(id) {
  return request({
    url: '/howe/article/detail',
    method: 'get',
    params: { id }
  })
}

export function fetchPv(pv) {
  return request({
    url: '/howe/article/pv',
    method: 'get',
    params: { pv }
  })
}

export function createArticle(data) {
  return request({
    url: '/howe/article/create',
    method: 'post',
    data
  })
}

export function updateArticle(data) {
  return request({
    url: '/howe/article/update',
    method: 'post',
    data
  })
}
